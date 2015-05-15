Ext.define('OrangeCandle.util.Auth', {
	singleton : true,
	set : function(username, password) {
		this.username = username;
		this.auth = 'Basic ' + btoa(username + ':' + password);
	},
	get : function() {
		return this.auth;
	},
	getUsername : function() {
		return this.username;
	}
});