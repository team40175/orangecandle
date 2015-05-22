Ext.define('OrangeCandle.view.AddConstraints', {
	extend : 'Ext.form.Panel',
	alias : "widget.addconstraints",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		scrollable : 'false',
		items : [ {
			xtype : 'fieldset',
			items : [ {
				xtype : 'hiddenfield',
				name : 'id'
			}, {
				xtype : 'textfield',
				placeHolder : 'Constraints:',
				name : 'text',
			}, ]
		}, {
			xtype : 'list',
			name : 'users',
			flex : 1,
			itemTpl : '{name}',
			store : 'xUser'
		}, {
			xtype : 'list',
			name : 'lectures',
			flex : 1,
			itemTpl : '{name}',
			store : 'Lecture'
		}, {
			xtype : 'list',
			name : 'classrooms',
			flex : 1,
			itemTpl : '{name}',
			store : 'Room'
		}, {
			xtype : 'button',
			text : 'Save',
			target : "constraint/add"
		} ]
	}
})