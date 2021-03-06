(function($){

    $.fn.Floaty = function(options) {

        var floaty = buildFloaty();

        floaty.show = show; 
        floaty.hideIn = hideIn;
        floaty.cancelHiding = cancelHiding;
        floaty.willHideSoon = willHideSoon;
        
        floaty.options = $.extend(true, {
            startPosition: {
                left: 0, 
                top: 0
            },
            animationDuration: 300,
            hideIn: 1000,
            floaty: floaty,
            timerHandle: null,
            appearingFirstTime: true
        }, options);    

        floaty.mouseenter(function(e){
             floaty.cancelHiding();
        });
        
        floaty.mouseleave(function(e){
            floaty.hideIn(floaty.options.hideIn);
        });

        return floaty;
    };
    
    function isIE6() {
        return ($.browser.msie && $.browser.version == "6.0");
    };

    function buildFloaty() {
        var body    = jQuery(document.createElement("div")).addClass("smartmenufloaty");
        var tip     = jQuery(document.createElement("div")).addClass((isIE6()) ? "tip tipIE6" : "tip");
        var padding = jQuery(document.createElement("div")).addClass((isIE6()) ? "padder padderIE6" : "padder");
        
        body.hide();
        body.append(tip);
        body.append(padding);

        jQuery("body").append(body);
        return body;
    };

    function willHideSoon() {
        return (this.options.timerHandle != null);
    };
    
    function cancelHiding() {
        window.clearInterval(this.options.timerHandle);
        this.options.timerHandle = null;
    };
    
    function show(position) {

        if (this.options.appearingFirstTime) {
            this.options.appearingFirstTime = false;
            this.css({
                "left" : this.options.startPosition.left + "px",
                "top" : this.options.startPosition.top + "px"
            });
        }

        this.fadeIn(this.options.animationDuration);
        this.animate({
                "top" : position.top +"px",
                "left" : position.left + "px"
            }, {
                queue: false, 
                duration: this.options.animationDuration
            }
        );
        
        if (this.willHideSoon())
            this.cancelHiding();
    };
    
    function hideIn(seconds) {
        var this_ = this;
        this.options.timerHandle = window.setTimeout(function(){
            this_.fadeOut(this_.options.animationDuration);
        }, seconds);
    };
    
})(jQuery);

(function($){
    $.fn.Smartmenu = function(opt) {
        var options = $.extend(true, {
            hideSubmenuIn: 1000,
            pushSubmenuDownBy: 30,
            animationDuration : 200
        }, opt);    

        options.floaty = jQuery("").Floaty({
            animationDuration: options.animationDuration,
            startPosition: jQuery(this).position()
        });
        
        options.padder = options.floaty.find((isIE6()) ? ".padderIE6" : ".padder");

        return this.each(function() {
            var context = {options : options, target : jQuery(this)};
            initialize(context);
        });
    };

    function isIE6() {
        return ($.browser.msie && $.browser.version == "6.0");
    };

    function initialize(context) {
        var self      = context.target;
        var topMenus  = self.find("ul:first");
        var listItems = topMenus.children();

        self.addClass((isIE6()) ? "smartmenuie6" : "");

        listItems.find("a:first").bind("mouseenter", context, topMenuEnter);
        listItems.find("a:first").bind("mouseleave", context, topMenuLeave);
        
        if (listItems.length > 0) {
            jQuery(listItems[listItems.length - 1]).find("a:first").addClass("last");
        }
    };

    function topMenuLeave(e) {
        var target = jQuery(e.target);
        var context = e.data;
        var hasSubmenus = (target.parent().find("ul").length > 0) ? true : false;
        
        if (context.options.floaty && hasSubmenus) 
            context.options.floaty.hideIn(context.options.hideSubmenuIn);
    };

    function topMenuEnter(e) {

        var target = jQuery(e.target);

        function getChildList(){
            var childList = target.parent().find("ul").clone(true); 
            childList.find("li:last").addClass("last");
            return childList;
        }

        var context = e.data;
        var childList = getChildList();

        if (childList.length == 0)
            return;
        
        var targetPos = target.position();
        var left      = parseInt(targetPos.left);
        var top       = parseInt(targetPos.top);
        var padding   = parseInt(target.css("padding-left"));

        context.options.padder.empty();
        context.options.padder.append(childList);

        context.options.floaty.show({
            top: top + context.options.pushSubmenuDownBy,
            left: left + padding
        })
    };
})(jQuery);