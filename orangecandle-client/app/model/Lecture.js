Ext.define('OrangeCandle.model.Lecture', {
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