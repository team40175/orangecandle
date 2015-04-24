Ext.define('OrangeCandle.view.AddGroups', {
	extend : 'Ext.form.Panel',
	alias : "widget.addgroups",
	requires : [ 'Ext.form.Panel', 'Ext.form.FieldSet' ],
	config : {
		layout : 'vbox',
		title : 'Group Adding:',
		itemId: 'groupPanel',
		items : [ {
			xtype : 'fieldset',
			flex : 1,
			items : [ {
				xtype : 'textfield',
				placeHolder : 'GroupName',
				itemId : 'groupNameTextField',
				name : 'groupNameTextField',
				required : true,

			} ]
		}, {
			xtype : 'list',
			flex : 2,
			mode : 'multi',
			itemId : 'grouplist',
			itemTpl : '{text}',
			store : 'Role',
//			data:[{
//				item1:'Student'
//			},{
//				item2:'Teacher'
//			},{
//				item3:'Advisor'
//			},{
//				item:'Administrator'
//			}
//			      ]

		}, {
			xtype : 'button',
			text : 'Submit',
			itemId : 'groupSubmitButton',
			handler : function() {
				Ext.ComponentQuery.query('#groupPanel')[0].submit({
					url : OrangeCandle.util.Scalability.getApplicationServer("group/add"),
					params:{
						groupName : Ext.ComponentQuery.query('#groupNameTextField')[0].getValue()
					},
					method : 'POST',
					success : function() {
						Ext.Msg.alert("success");
					}
				});
			}
		} ]
	}
})