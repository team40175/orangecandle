Ext.define('OrangeCandle.view.AddClassroom', {
	extend : 'Ext.form.Panel',
	alias : "widget.addclassroom",
	requires : [ 'Ext.form.FieldSet' ],
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
				placeHolder : 'Name of the Classroom',
				name : 'name',
			}, ]
		}, {
			xtype : 'list',
			name : 'buildings',
			flex : 1,
			itemTpl : '{name}',
			store : 'Building'
		}, {
			xtype : 'button',
			text : 'Save',
			target : "room/add"
		} ]
	}
})