Ext.define('OrangeCandle.view.AddSchool', {
	extend : 'Ext.form.Panel',
	alias : "widget.addschool",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		title : 'Insert a new School',
		itemId : 'schoolPanel',
		items : [
				{
					xtype : 'fieldset',
					items : [ {
						xtype : 'textfield',
						placeHolder : 'Name of the School',
						itemId : 'schoolName',
						name : 'name',
						required : true
					} ]
				},
				{
					xtype : 'button',
					text : 'submit',
					handler : function() {
						Ext.ComponentQuery.query('#schoolPanel')[0].submit({
							url : OrangeCandle.util.Scalability
									.getApplicationServer("school/add"),

							method : 'POST',
							success : function() {
								Ext.Msg.alert("success");
							}
						});
					}
				} ]
	}
})
