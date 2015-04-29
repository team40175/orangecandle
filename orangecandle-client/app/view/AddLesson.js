Ext.define('OrangeCandle.view.AddLesson', {
	extend : 'Ext.form.Panel',
	alias : "widget.addlesson",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		title : 'Insert a new lecture',
		instructions : 'Insert the details of the lecture:',
		itemId : 'lessonPanel',
		items : [
				{
					xtype : 'fieldset',
					items : [ {
						xtype : 'textfield',
						placeHolder : 'Code of the lecture',
						itemId : 'lessonCode',
						name : 'lectureCode',
						required : true
					}, {
						xtype : 'textfield',
						placeHolder : 'Name of the lecture',
						itemId : 'lessonUserName',
						name : 'lectureName',
						required : true
					}, {
						xtype : 'textfield',
						placeHolder : 'Classroom of the lecture',
						itemId : 'lessonRoom',
						name : 'RoomName',
						required : true
					} ]
				},
				{
					xtype : 'button',
					text : 'submit',
					handler : function() {
						Ext.ComponentQuery.query('#lessonPanel')[0].submit({
							url : OrangeCandle.util.Scalability
									.getApplicationServer("lecture/add"),

							method : 'POST',
							success : function() {
								Ext.Msg.alert("success");
							}
						});
					}
				} ]
	}
})
