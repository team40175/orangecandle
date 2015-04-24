Ext
		.define(
				'OrangeCandle.view.AddClassroom',
				{
					extend : 'Ext.form.Panel',
					alias : "widget.addclassroom",
					requires : [ 'Ext.form.FieldSet' ],
					config : {
						title : 'Classroom Information:',
						itemId : 'classroomPanel',
						items : [
								{
									xtype : 'fieldset',
									items : [
											{
												xtype : 'textfield',
												itemId : 'classroomName',
												placeHolder : 'Name of the Classroom',
												name : 'code',
												required : true
											},
											{
												xtype : 'textfield',
												placeHolder : 'Building of the Classroom',
												itemId : 'classroomBuilding',
												name : 'name',
												required : true
											},
											{
												xtype : 'textfield',
												placeHolder : 'School of the Classroom',
												itemId : 'classroomSchool',
												name : 'name',
												required : true
											} ]
								},
								{
									xtype : 'button',
									text : 'submit',
									handler : function() {
										Ext.ComponentQuery
												.query('#classroomPanel')[0]
												.submit({
													url : OrangeCandle.util.Scalability
															.getApplicationServer("room/add"),
													params : {
														roomName : Ext.ComponentQuery
																.query('#,classroomName')[0]
																.getValue(),
														roomBuilding : Ext.ComponentQuery
																.query('#,classroomBuilding')[0]
																.getValue(),
														roomSchool : Ext.ComponentQuery
																.query('#,classroomSchool')[0]
																.getValue()
													},
													method : 'POST',
													success : function() {
														Ext.Msg
																.alert("success");
													}
												});
									}
								} ]
					}
				})