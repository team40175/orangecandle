Ext.define('OrangeCandle.view.AddLesson', {
	extend : 'Ext.form.Panel',
	alias : "widget.addlesson",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		scrollable : 'false',
		title : 'Insert a new lecture',
		instructions : 'Insert the details of the lecture:',
		layout : 'vbox',
		items : [ {
			xtype : 'fieldset',
			items : [ {
				xtype : 'hiddenfield',
				name : 'id'
			}, {
				xtype : 'textfield',
				placeHolder : 'Code of the lecture',
				name : 'code'
			}, {
				xtype : 'textfield',
				placeHolder : 'Name of the lecture',
				name : 'name'
			}, {
				xtype : 'textfield',
				placeHolder : 'Description',
				name : 'description'
			} ]
		}, {
			xtype : 'list',
			name : 'department',
			flex : 1,
			itemTpl : '{name}',
			store : 'Department'
		}, {
			xtype : 'button',
			text : 'submit',
			target : 'lecture/add'
		} ]
	}
})
