Ext.define('OrangeCandle.view.AddAccount', {
	extend : 'Ext.form.Panel',
	alias : "widget.addaccount",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		layout : 'vbox',
		itemId : 'accountPanel',
		title : 'Insert Account',
		scrollable : false,
		items : [
				{
					xtype : 'fieldset',
					items : [ {
						xtype : 'textfield',
						itemId : 'userName',
						placeHolder : 'username',
						name : 'UserName',
						required : true
					} ]
				},
				{
					xtype : 'list',
					flex : 1,
					itemId : 'groupList', 
					mode : 'multi',
					itemTpl : '{name}',
					store : 'Group'
				},
				{
					xtype : 'button',
					text : 'submit',
					handler : function() {
						Ext.ComponentQuery.query('#accountPanel')[0].submit({
							url : OrangeCandle.util.Scalability
									.getApplicationServer("user/add"),
							
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