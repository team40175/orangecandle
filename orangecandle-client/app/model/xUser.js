Ext.define('OrangeCandle.model.xUser', {
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