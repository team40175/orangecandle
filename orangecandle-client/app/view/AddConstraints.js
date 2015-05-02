Ext
		.define(
				'OrangeCandle.view.AddConstraints',
				{
					extend : 'Ext.form.Panel',
					alias : "widget.addconstraints",
					requires : [ 'Ext.form.FieldSet' ],
					config : {
						title : 'Please inform us about your demands!',
						itemId : 'constraintPanel',
						items : [
								{
									xtype : 'fieldset',
									items : [ {
										xtype : 'textfield',
										placeHolder : 'Constraints:',
										itemId : 'constraint',
										name : 'text',
										required : true
									}, {
										xtype : 'textfield',
										placeHolder : 'User',
										itemId : 'constraintUser',
										name : 'userName',
										required : true
									}, {
										xtype : 'textfield',
										placeHolder : 'Lecture',
										itemId : 'constraintLecture',
										name : 'lectureCode',
										required : true
									}, {
										xtype : 'textfield',
										placeHolder : 'Classroom',
										itemId : 'constraintRoom',
										name : 'roomName',
										required : true
									} ]
								},
								{
									xtype : 'button',
									text : 'submit',
									handler : function() {
										Ext.ComponentQuery
												.query('#constraintPanel')[0]
												.submit({
													url : OrangeCandle.util.Scalability
															.getApplicationServer("constraint/add"),

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