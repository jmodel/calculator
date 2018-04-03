package com.github.jmodel.calculator.entity.template.tree;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jmodel.calculator.entity.template.DataSource;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tree implements DataSource {

	/**
	 * Tree item meta info is defined at Tree level for performance reason.
	 */
	private Map<String, TreeItemMeta> treeItemMetas;

	private TreeItem[] data;

	public Map<String, TreeItemMeta> getTreeItemMetas() {
		return treeItemMetas;
	}

	public void setTreeItemMetas(Map<String, TreeItemMeta> treeItemMetas) {
		this.treeItemMetas = treeItemMetas;
	}

	public TreeItem[] getData() {
		return data;
	}

	public void setData(TreeItem[] data) {
		this.data = data;
	}

}
