Ext.define('OrangeCandle.view.AddClassroom', {
	extend : 'Ext.form.Panel',
	alias : "widget.addclassroom",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		items : [
				{
					xtype : 'fieldset',
					items : [ {
						xtype : 'textfield',
						placeHolder : 'Name of the Classroom',
						name : 'name',
					}, {
						xtype : 'textfield',
						placeHolder : 'Building of the Classroom',
						name : 'building',
					}, ]
				},
				{
					xtype : 'button',
					text : 'submit',
					handler : function() {
						Ext.ComponentQuery.query('#classroomPanel')[0].submit({
							url : OrangeCandle.util.Scalability
									.getApplicationServer("room/add"),
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