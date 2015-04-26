Ext.define('OrangeCandle.view.AddClassroom', {
	extend : 'Ext.form.Panel',
	alias : "widget.addclassroom",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		title : 'Classroom Information:',
		itemId : 'classroomPanel',
		items : [
				{
					xtype : 'fieldset',
					items : [ {
						xtype : 'textfield',
						itemId : 'classroomName',
						placeHolder : 'Name of the Classroom',
						name : 'roomName',
						required : true
					}, {
						xtype : 'textfield',
						placeHolder : 'Building of the Classroom',
						itemId : 'classroomBuilding',
						name : 'buildingName',
						required : true
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
							success : function() {
								Ext.Msg.alert("success");
							}
						});
					}
				} ]
	}
})