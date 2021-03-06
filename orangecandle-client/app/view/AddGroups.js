Ext.define('OrangeCandle.view.AddGroups', {
	extend : 'Ext.form.Panel',
	alias : "widget.addgroups",
	requires : [ 'Ext.form.Panel', 'Ext.form.FieldSet' ],
	config : {
		layout : 'vbox',
		scrollable : 'false',
		items : [ {
			xtype : 'fieldset',
			items : [ {
				xtype : 'hiddenfield',
				name : 'id'
			}, {
				xtype : 'textfield',
				placeHolder : 'Group name',
				name : 'name',
			} ]
		}, {
			xtype : 'list',
			flex : 2,
			mode : 'multi',
			name : 'roles',
			itemId : 'grouplist',
			itemTpl : '{name}',
			store : 'Role',

		}, {
			xtype : 'button',
			text : 'Save',
			target : "group/add"
		} ]
	}
})