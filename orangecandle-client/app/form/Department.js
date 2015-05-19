Ext.define('OrangeCandle.form.Department', {
	extend : 'Ext.form.Panel',
	alias : "widget.departmentform",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		layout : 'vbox',
		title : 'Insert Account',
		scrollable : false,
		items : [ {
			xtype : 'fieldset',
			items : [ {
				xtype : 'hiddenfield',
				name : 'id'
			}, {
				xtype : 'textfield',
				placeHolder : 'Name of the Department',
				name : 'name',
				required : true
			} ]
		}, {
			xtype : 'list',
			name : 'faculties',
			flex : 1,
			itemTpl : '{name}',
			store : 'Faculty'
		}, {
			xtype : 'button',
			text : 'submit',
			target : "department/add"
		} ]
	}

})