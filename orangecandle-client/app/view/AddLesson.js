Ext.define('OrangeCandle.view.AddLesson', {
	extend : 'Ext.form.Panel',
	alias : "widget.addlesson",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		title : 'Insert a new lecture',
		instructions : 'Insert the details of the lecture:',
		itemId : 'lessonPanel',
		items : [ {
			xtype : 'fieldset',
			items : [ {
				xtype : 'textfield',
				placeHolder : 'Code of the lecture',
				name : 'lectureCode',
			}, {
				xtype : 'textfield',
				placeHolder : 'Name of the lecture',
				name : 'name',
			}, {
				xtype : 'textfield',
				placeHolder : 'Description',
				name : 'desc',
			} ]
		}, {
			xtype : 'button',
			text : 'submit',
			target : 'lecture/add'
		} ]
	}
})
