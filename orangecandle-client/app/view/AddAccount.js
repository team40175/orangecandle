Ext.define('OrangeCandle.view.AddAccount', {
	extend : 'Ext.form.Panel',
	alias : "widget.addaccount",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		layout : 'vbox',
		title : 'Insert Account',
		scrollable : false,
		items : [ {
			xtype : 'fieldset',
			items : [ {
				xtype : 'textfield',
				placeHolder : 'username',
				name : 'name',
				required : true
			} ]
		}, {
			xtype : 'list',
			flex : 1,
			mode : 'multi',
			itemTpl : '{name}',
			store : 'Group'
		} ]
	}
})