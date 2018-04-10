package com.github.jmodel.calculator.function;

import java.math.BigDecimal;
import java.util.List;

import com.github.jmodel.calculator.CalculationException;
import com.github.jmodel.calculator.CalculatorTerms;
import com.github.jmodel.calculator.Context;
import com.github.jmodel.calculator.entity.instance.InstanceItem;
import com.github.jmodel.calculator.entity.instance.Step;
import com.github.jmodel.calculator.entity.template.Condition;
import com.github.jmodel.calculator.entity.template.Router;
import com.github.jmodel.calculator.entity.template.StepDef;
import com.github.jmodel.calculator.entity.template.tree.Tree;
import com.github.jmodel.calculator.entity.template.tree.TreeItem;
import com.github.jmodel.calculator.entity.template.tree.TreeItemMeta;

/**
 * TreeStepFunc is the simplest step regarding tree data. This step is often put
 * at the first step of a calculation procedure, no dependent step, just pick up
 * data from a tree. The result of this step would be used by subsequent steps.
 * 
 * @author jianni@hotmail.com
 *
 */
public class TreeStepFunc extends PickStepFunc {

	private static TreeStepFunc instance;

	private TreeStepFunc() {
	}

	public final static TreeStepFunc getInstance() {
		if (instance != null) {
			return instance;
		}

		synchronized (TreeStepFunc.class) {
			if (instance == null) {
				instance = new TreeStepFunc();
			}
			return instance;
		}
	}

	@Override
	protected final BigDecimal pickup(Context context, StepDef stepDef, Step step, StepDef depStepDef, Step depStep) {

		// find tree
		Tree tree = null;
		for (Router router : context.getTemplateItem().getRouters()) {
			if (!(router.getDataSource() instanceof Tree)) {
				continue;
			}

			boolean passed = true;
			List<Condition> conditions = router.getConditions();
			if (conditions != null && conditions.size() > 0) {
				for (Condition condition : conditions) {
					InstanceItem matchedInstanceItem = findInstanceItem(context.getInstanceItem(),
							condition.getMapToTemplateItemTypeTerm(), condition.getMapToTemplateItemTerm());
					if (matchedInstanceItem != null) {
						String attributeValue = matchedInstanceItem.getAttributes().get(condition.getMapToAttribute());
						if (!(condition.getExpectValue().equals(attributeValue))) {
							passed = false;
							break;
						}
					}
				}
			}
			if (passed) {
				tree = (Tree) (router.getDataSource());
			}
		}

		if (tree == null) {
			throw new CalculationException(CalculatorTerms.E_TREE_NOT_FOUND);
		}

		int layers = (int) step.getObject();
		TreeItem rootTreeItem = tree.getData()[0];
		String rawValue = null;
		if (layers > 0) {
			rawValue = findRawValue(context.getInstanceItem(), tree, rootTreeItem, layers);
		} else {
			rawValue = rootTreeItem.getRawValue();
		}

		return new BigDecimal(rawValue);
	}

	/**
	 * Get raw value of matched tree item.
	 * 
	 * @param instanceItem
	 *            instance item is used to find attribute raw value
	 * @param tree
	 *            tree instance
	 * @param parentTreeItem
	 *            parent tree item
	 * @param layers
	 *            layer of trying finding
	 * @return the raw value of matched tree item
	 */
	protected final String findRawValue(InstanceItem instanceItem, Tree tree, TreeItem parentTreeItem,
			final int layers) {

		int parentIndex = parentTreeItem.getIndex();
		TreeItem leftTreeItem = tree.getData()[2 * parentIndex];
		TreeItem rightTreeItem = tree.getData()[(2 * parentIndex) + 1];
		if (parentTreeItem.getLayer() == (layers - 1)) {
			// seek raw value in the next layer
			if (leftTreeItem != null && check(instanceItem, tree, leftTreeItem)) {
				return leftTreeItem.getRawValue();
			} else {
				if (rightTreeItem != null && check(instanceItem, tree, rightTreeItem)) {
					return rightTreeItem.getRawValue();
				} else {
					throw new CalculationException(CalculatorTerms.E_TREE_ITEM_NOT_DEFINED);
				}
			}
		} else {
			if (leftTreeItem != null && check(instanceItem, tree, leftTreeItem)) {
				return findRawValue(instanceItem, tree, leftTreeItem, layers);
			} else {
				if (rightTreeItem != null && check(instanceItem, tree, rightTreeItem)) {
					return findRawValue(instanceItem, tree, rightTreeItem, layers);
				} else {
					throw new CalculationException(CalculatorTerms.E_TREE_ITEM_NOT_DEFINED);
				}
			}
		}
	}

	/**
	 * Check if the tree item meets the defined conditions.
	 * 
	 * @param instanceItem
	 *            instance item is used to find attribute raw value
	 * @param tree
	 *            tree is used to get tree item meta info
	 * @param treeItem
	 *            tree item
	 * @return return true if meet the defined condition
	 */
	protected final boolean check(InstanceItem instanceItem, Tree tree, TreeItem treeItem) {
		TreeItemMeta treeItemMeta = tree.getTreeItemMetas().get(treeItem.getTerm());
		String rawAttributeValue = findRawAttributeValue(instanceItem, treeItemMeta.getMapToTemplateItemTypeTerm(),
				treeItemMeta.getMapToTemplateItemTerm(), treeItemMeta.getMapToAttribute());
		if (treeItem.getMatcher().match(rawAttributeValue)) {
			return true;
		}
		return false;
	}

}
