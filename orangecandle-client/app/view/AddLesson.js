Ext.define('OrangeCandle.view.AddLesson', {
	extend : 'Ext.form.Panel',
	alias : "widget.addlesson",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		title : 'Insert a new lecture',
		instructions : 'Insert the details of the lecture:',
		items : [ {
			xtype : 'fieldset',
			items : [ {
				xtype : 'textfield',
				placeHolder : 'Code of the lecture',
				name : 'code',
				required : true
			}, {
				xtype : 'textfield',
				placeHolder : 'Name of the lecture',
				name : 'name',
				required : true
			} ]
		}, {
			xtype : 'button',
			text : 'submit'
		} ]
	}
})
