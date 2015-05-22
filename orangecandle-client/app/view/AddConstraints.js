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
			}, {
				xtype : 'textfield',
				placeHolder : 'User',
				name : 'userName',
			}, {
				xtype : 'textfield',
				placeHolder : 'Lecture',
				name : 'lectureCode',
			}, {
				xtype : 'textfield',
				placeHolder : 'Classroom',
				name : 'roomName',
			} ]
		}, {
			xtype : 'button',
			text : 'Save',
			target : "constraint/add"
		} ]
	}
})