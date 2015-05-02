Ext.define('OrangeCandle.view.template.List', {
	extend : 'Ext.Panel',
	xtype : 'remotelist',
	items : [ {
		xtype : 'list',
		itemTpl : this.itemTpl,
		mode : this.mode,
		store : this.store
	} ]
});