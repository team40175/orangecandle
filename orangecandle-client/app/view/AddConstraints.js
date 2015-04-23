Ext.define('OrangeCandle.view.AddConstraints', {
	extend : 'Ext.form.Panel',
	alias : "widget.addconstraints",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		title : 'Please inform us about your demands!',
//		instructions : 'Insert the details of the lecture:',
		items : [ {
			xtype : 'fieldset',
			items : [ {
				xtype : 'textfield',
				placeHolder : 'Constraints:',
				name : 'code',
				required : true
			}]
		}, 
		{
			xtype : 'button',
			text : 'submit'
		} ]
	}
})