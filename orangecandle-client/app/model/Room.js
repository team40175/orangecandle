Ext.define('OrangeCandle.model.Room', {
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