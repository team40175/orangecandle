Ext.define('OrangeCandle.view.AddLesson', {
	extend : 'Ext.form.Panel',
	alias : "widget.addlesson",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		title : 'Lesson crecedentials:',
		items : [ {
			xtype : 'fieldset',
			title : 'Lesson',
			items : [ {
				xtype : 'textfield',
				placeHolder : 'lessonName',
				itemId : 'lessonNameTextField',
				name : 'lessonNameTextField',
				required : true
			},{
				xtype : 'textfield',
				placeHolder : 'lessonInformation',
				itemId : 'lessonInfoTextField',
				name : 'lessonInfoTextField',
				required : true
			},{
				xtype : 'textfield',
				placeHolder : 'lessonRoom',
				itemId : 'lessonRoomTextField',
				name : 'lessonRoomTextField',
				required : true
			} 
			]
		} ]
	}
})
