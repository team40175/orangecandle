Ext.define('OrangeCandle.view.AddGroups', {
	extend : 'Ext.form.Panel',
	alias : "widget.addgroups",
	requires : [ 'Ext.form.Panel', 'Ext.form.FieldSet' ],
	config : {
		layout : 'vbox',
		itemId : 'groupPanel',
		items : [
				{
					xtype : 'fieldset',
					items : [ {
						xtype : 'textfield',
						placeHolder : 'GroupName',
						itemId : 'groupNameTextField',
						name : 'groupName',
						required : true,

					} ]
				},
				{
					xtype : 'list',
					flex : 2,
					mode : 'multi',
					itemId : 'grouplist',
					itemTpl : '{name}',
					store : 'Role',

				},
				{
					xtype : 'button',
					text : 'Submit',
					itemId : 'groupSubmitButton',
					handler : function() {
						Ext.ComponentQuery.query('#groupPanel')[0].submit({
							url : OrangeCandle.util.Scalability
									.getApplicationServer("group/add"),

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