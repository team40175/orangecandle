Ext
		.define(
				'OrangeCandle.view.AddAccount',
				{
					extend : 'Ext.form.Panel',
					alias : "widget.addaccount",
					requires : [ 'Ext.form.FieldSet' ],
					config : {
						layout : 'vbox',
						itemId:'accountPanel',
						title : 'Insert Account',
						scrollable : false,
						items : [
								{
									xtype : 'fieldset',
									items : [ {
										xtype : 'textfield',
										itemId:'userName',
										placeHolder : 'username',
										name : 'name',
										required : true
									} ]
								},
//								{
//									xtype : 'list',
//									flex : 1,
//									mode : 'multi',
//									itemTpl : '{name}',
//									store : 'Group'
//								},
								{
									xtype : 'button',
									text : 'submit',
									handler : function() {
										Ext.ComponentQuery
												.query('#accountPanel')[0]
												.submit({
													url : OrangeCandle.util.Scalability
															.getApplicationServer("user/add"),
													params : {
														userName : Ext.ComponentQuery
																.query('#userName')[0]
																.getValue(),
														
													},
													method : 'POST',
													success : function() {
														Ext.Msg
																.alert("success");
													},
													failure : function(form,result) {
														Ext.Msg
																.alert(result.toString);
													
													}
												});
									}
								} ]
					}

				})