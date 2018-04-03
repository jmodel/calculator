package com.github.jmodel.calculator.function;

import java.math.BigDecimal;
import java.util.List;

import com.github.jmodel.calculator.Context;
import com.github.jmodel.calculator.entity.instance.Step;
import com.github.jmodel.calculator.entity.template.Condition;
import com.github.jmodel.calculator.entity.template.Matchable;
import com.github.jmodel.calculator.entity.template.Router;
import com.github.jmodel.calculator.entity.template.StepDef;
import com.github.jmodel.calculator.entity.template.table.Table;
import com.github.jmodel.calculator.entity.template.table.TableMeta;

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

		// find table
		Table table = null;
		for (Router router : context.getTemplateItem().getRouters()) {
			if (!(router.getDataSource() instanceof Table)) {
				continue;
			}

			boolean passed = true;
			List<Condition> conditions = router.getConditions();
			if (conditions != null && conditions.size() > 0) {
				for (Condition condition : conditions) {
					String attributeValue = findRawAttributeValue(context.getInstanceItem(),
							condition.getMapToTemplateItemTypeTerm(), condition.getMapToTemplateItemTerm(),
							condition.getMapToAttribute());
					if (attributeValue != null) {
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

		TableMeta tableMeta = table.getTableMeta();
		int x = 0;
		int y = 0;

		String colAttributeValue = findRawAttributeValue(context.getInstanceItem(),
				tableMeta.getColMapToTemplateItemTypeTerm(), tableMeta.getColMapToTemplateItemTerm(),
				tableMeta.getColMapToAttribute());
		if (colAttributeValue != null) {
			for (Matchable rateTableRowMeta : tableMeta.getColumns()) {
				if (rateTableRowMeta.match(colAttributeValue)) {
					x = (int) rateTableRowMeta.getIndex();
					break;
				}
			}
		}

		String rowAttributeValue = findRawAttributeValue(context.getInstanceItem(),
				tableMeta.getRowMapToTemplateItemTypeTerm(), tableMeta.getRowMapToTemplateItemTerm(),
				tableMeta.getRowMapToAttribute());
		if (rowAttributeValue != null) {
			for (Matchable rateTableRowMeta : tableMeta.getRows()) {
				if (rateTableRowMeta.match(rowAttributeValue)) {
					y = (int) rateTableRowMeta.getIndex();
					break;
				}
			}
		}

		if (y < 0) {
			throw new RuntimeException("TODO ffffffffffff");
		}

		return new BigDecimal(table.getRawData()[y][x]);
	}

}
