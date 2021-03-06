Ext.define('OrangeCandle.controller.Submit', {
	extend : 'Ext.app.Controller',
	config : {
		refs : {
			mainView : 'mainmenuview'
		},
		control : {
			'button[target]' : {
				tap : 'onClick'
			}
		}
	},
	onClick : function(button, event, options) {
		var mainView = this.getMainView();
		var formtype = button.up('formpanel').xtype;
		var lists = Ext.ComponentQuery.query(button.up('formpanel').xtype
				+ ' list');
		var submitOpts = {
			headers : {
				Authorization : OrangeCandle.util.Auth.get()
			},
			params : {},
			url : OrangeCandle.util.Scalability
					.getApplicationServer(button.target),
			method : 'POST',
			success : function(form, result) {
				Ext.Msg.alert('', result.message, function() {
					mainView.pop();
				});
			},
			failure : function(form, result) {
				Ext.Msg.alert('', result.message, Ext.emptyFn);
			}
		};

		for ( var i in lists) {
			var selections = lists[i].getSelection();
			var key = lists[i].name;
			var values = [];
			var j = 0;
			for ( var k in selections) {
				if (isFinite(selections[k]))
					continue;
				values[j++] = selections[k].data.id;
			}
			submitOpts.params[key] = '[' + values + ']';
		}

		button.up('panel').submit(submitOpts);
	}
});