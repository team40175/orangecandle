Ext.define('OrangeCandle.model.Group', {
	extend : 'Ext.data.Model',
	config : {
		fields : [ {
			name : 'oid',
			type : 'int'
		}, {
			name : 'name',
			type : 'string'
		} ]
	}
});