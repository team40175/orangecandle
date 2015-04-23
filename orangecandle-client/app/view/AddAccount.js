Ext.define('OrangeCandle.view.AddAccount', {
	extend : 'Ext.form.Panel',
	alias : "widget.addaccount",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		title : 'Account Adding:',
		items : [ {
			xtype : 'fieldset',
			title : 'Account Information:',
			items : [ {
				xtype : 'textfield',
				placeHolder : 'accountName',
				itemId : 'accountNameTextField',
				name : 'accountNameTextField',
				required : true
			},{
				xtype: 'list',
                id :'groupSelection',
                mode:'multi',
                itemTpl : '{text}',
                data: [
                    {text: 'Student'},
                    {text: 'Teacher'},
                    {text: 'Administrator'}
                ]
            }			
			]
		} ]
	}
})