Ext.define('OrangeCandle.view.AddGroups', {
	extend : 'Ext.form.Panel',
	alias : "widget.addgroups",
	requires : [ 'Ext.form.Panel', 'Ext.form.FieldSet' ],
	config : {
		layout : 'vbox',
		scrollable:'false',
		items : [ {
			xtype : 'fieldset',
			items : [ {
				xtype : 'textfield',
				placeHolder : 'GroupName',
				itemId : 'groupNameTextField',
				name : 'groupName',
				required : true,

			} ]
		}, {
			xtype : 'list',
			flex : 2,
			mode : 'multi',
			itemId : 'grouplist',
			itemTpl : '{name}',
			store : 'Role',

		}, {
			xtype : 'button',
			text : 'Submit',
			target : "group/add"
		} ]
	}
})