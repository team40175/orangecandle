Ext.define('OrangeCandle.view.AddConstraints', {
	extend : 'Ext.form.Panel',
	alias : "widget.addconstraints",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		items : [
				{
					xtype : 'fieldset',
					items : [ {
						xtype : 'textfield',
						placeHolder : 'Constraints:',
						name : 'text',
					}, {
						xtype : 'textfield',
						placeHolder : 'User',
						name : 'userName',
					}, {
						xtype : 'textfield',
						placeHolder : 'Lecture',
						name : 'lectureCode',
					}, {
						xtype : 'textfield',
						placeHolder : 'Classroom',
						name : 'roomName',
					} ]
				},
				{
					xtype : 'button',
					text : 'submit',
					handler : function(button) {
						button.up('formpanel').submit({
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