package com.github.jmodel.calculator.function;

import java.math.BigDecimal;
import java.util.List;

import com.github.jmodel.calculator.Context;
import com.github.jmodel.calculator.entity.definition.Condition;
import com.github.jmodel.calculator.entity.definition.Router;
import com.github.jmodel.calculator.entity.definition.StepDef;
import com.github.jmodel.calculator.entity.definition.table.Table;
import com.github.jmodel.calculator.entity.definition.tree.Tree;
import com.github.jmodel.calculator.entity.definition.tree.TreeItem;
import com.github.jmodel.calculator.entity.instance.InstanceItem;
import com.github.jmodel.calculator.entity.instance.Step;

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

		Tree tree = new Tree();
		List<?> pathList = (List<?>) step.getObject();
		for (int layer = 0; layer < pathList.size(); layer++) {

			TreeItem<?> leftTreeItem = tree.getData()[2 * layer];

		}

		// find corresponding table
		Table table = null;
		for (Router router : context.getTemplateItem().getRouters()) {
			if (!(router.getDataSource() instanceof Table)) {
				continue;
			}

			boolean passed = true;
			List<Condition> conditions = router.getConditions();
			if (conditions != null && conditions.size() > 0) {
				for (Condition condition : conditions) {

					InstanceItem matchedInstanceItem = findInstanceElement(context.getInstanceItem(),
							condition.getMapToTemplateItemTypeTerm(), condition.getMapToTemplateItemTerm());
					if (matchedInstanceItem != null) {
						String attributeValue = (String) matchedInstanceItem.getAttributes()
								.get(condition.getMapToAttribute());
						if (!(condition.getExpectValue().equals(attributeValue))) {
							passed = false;
							break;
						}
					}
				}
			}
			if (passed) {
				table = (Table) (router.getDataSource());
			}
		}

		if (table == null) {
			throw new RuntimeException("TODO xxxxxxxxxxxxxxxxx");
		}

		// if (coverage.getQuotation().isMonthly()) {
		// rateTable = coverageDef.getMonthlyRateTable();
		// }

		int x = 0;
		int y = 0;

		return table.getData()[y][x];
	}

}
