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
						name : 'lectureCode',
						required : true
					}, {
						xtype : 'textfield',
						placeHolder : 'Name of the lecture',
						name : 'name',
						required : true
					}, {
						xtype : 'textfield',
						placeHolder : 'Description',
						name : 'desc',
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
							success : function(form, result) {
								Ext.Msg.alert('', result.message, function() {
									OrangeCandle.util.Scalability.pop()
								});
							},
							failure : function(form, result) {
								Ext.Msg.alert(result.message);
							}
						});
					}
				} ]
	}
})
