package com.github.jmodel.calculator.function;

import java.math.BigDecimal;
import java.util.List;

import com.github.jmodel.calculator.Context;
import com.github.jmodel.calculator.entity.instance.InstanceItem;
import com.github.jmodel.calculator.entity.instance.Step;
import com.github.jmodel.calculator.entity.template.Condition;
import com.github.jmodel.calculator.entity.template.Router;
import com.github.jmodel.calculator.entity.template.StepDef;
import com.github.jmodel.calculator.entity.template.tree.Tree;
import com.github.jmodel.calculator.entity.template.tree.TreeItem;
import com.github.jmodel.calculator.entity.template.tree.TreeItemMeta;

public final class TreeStepFunc extends StepFunc {

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
	protected BigDecimal calculate(Context context, StepDef stepDef, Step step, StepDef depStepDef, Step depStep) {

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
			throw new RuntimeException("TODO xxxxxxxxxxxxxxxxx");
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

	private String findRawValue(InstanceItem instanceItem, Tree tree, TreeItem parentTreeItem, final int layers) {

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
					throw new RuntimeException("at least one side tree item should be defined");
				}
			}
		} else {
			if (leftTreeItem != null && check(instanceItem, tree, leftTreeItem)) {
				return findRawValue(instanceItem, tree, leftTreeItem, layers);
			} else {
				if (rightTreeItem != null && check(instanceItem, tree, rightTreeItem)) {
					return findRawValue(instanceItem, tree, rightTreeItem, layers);
				} else {
					throw new RuntimeException("at least one side tree item should be defined");
				}
			}
		}
	}

	private boolean check(InstanceItem instanceItem, Tree tree, TreeItem treeItem) {
		TreeItemMeta treeItemMeta = tree.getTreeItemMetas().get(treeItem.getTerm());
		String rawAttributeValue = findRawAttributeValue(instanceItem, treeItemMeta.getMapToTemplateItemTypeTerm(),
				treeItemMeta.getMapToTemplateItemTerm(), treeItemMeta.getMapToAttribute());
		if (treeItem.getMatcher().match(rawAttributeValue)) {
			return true;
		}
		return false;
	}

}
