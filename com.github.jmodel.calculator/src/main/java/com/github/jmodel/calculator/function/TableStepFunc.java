package com.github.jmodel.calculator.function;

import java.math.BigDecimal;
import java.util.List;

import com.github.jmodel.calculator.Context;
import com.github.jmodel.calculator.entity.definition.Condition;
import com.github.jmodel.calculator.entity.definition.Router;
import com.github.jmodel.calculator.entity.definition.StepDef;
import com.github.jmodel.calculator.entity.definition.table.Table;
import com.github.jmodel.calculator.entity.definition.table.TableMeta;
import com.github.jmodel.calculator.entity.definition.table.TableRowMeta;
import com.github.jmodel.calculator.entity.instance.InstanceItem;
import com.github.jmodel.calculator.entity.instance.Step;
import com.github.jmodel.calculator.entity.instance.table.Point;

public final class TableStepFunc extends StepFunc {

	private static TableStepFunc instance;

	private TableStepFunc() {
	}

	public final static TableStepFunc getInstance() {
		if (instance != null) {
			return instance;
		}

		synchronized (TableStepFunc.class) {
			if (instance == null) {
				instance = new TableStepFunc();
			}
			return instance;
		}
	}

	@Override
	protected BigDecimal calculate(Context context, StepDef stepDef, Step step, StepDef depStepDef, Step depStep) {

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

		TableMeta tableMeta = table.getTableMeta();
		Point point = (Point) step.getObject();
		int x = tableMeta.getColumnNames().indexOf(point.getX());
		int y = 0;

		InstanceItem matchedInstanceItem = findInstanceElement(context.getInstanceItem(),
				tableMeta.getRowMapToTemplateItemTypeTerm(), tableMeta.getRowMapToTemplateItemTerm());

		if (matchedInstanceItem != null) {
			Object attributeValue = matchedInstanceItem.getAttributes().get(tableMeta.getRowMapToAttribute());
			TableRowMeta rateTableRowMeta = tableMeta.getRows().stream().filter(item -> item.match(attributeValue))
					.findFirst().orElse(null);
			y = rateTableRowMeta.getIndex();
		}

		return table.getData()[y][x];
	}

}
