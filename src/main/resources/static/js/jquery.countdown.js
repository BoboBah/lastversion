!function(e){e.fn.countdown=function(t,n){var o=e.extend({date:null,offset:null,day:"Day",days:"Days",hour:"Hour",hours:"Hours",minute:"Minute",minutes:"Minutes",second:"Second",seconds:"Seconds"},t);o.date||e.error("Date is not defined."),Date.parse(o.date)||e.error("Incorrect date format, it should look like this, 12/24/2012 12:00:00.");var r=this,i=function(){var e=new Date,t=e.getTime()+6e4*e.getTimezoneOffset();return new Date(t+36e5*o.offset)};var s=setInterval(function(){var e=new Date(o.date)-i();if(e<0)return clearInterval(s),void(n&&"function"==typeof n&&n());var t=Math.floor(e/864e5),a=Math.floor(e%864e5/36e5),d=Math.floor(e%36e5/6e4),f=Math.floor(e%6e4/1e3),u=1===t?o.day:o.days,l=1===a?o.hour:o.hours,c=1===d?o.minute:o.minutes,h=1===f?o.second:o.seconds;t=String(t).length>=2?t:"0"+t,a=String(a).length>=2?a:"0"+a,d=String(d).length>=2?d:"0"+d,f=String(f).length>=2?f:"0"+f,r.find(".days").text(t),r.find(".hours").text(a),r.find(".minutes").text(d),r.find(".seconds").text(f),r.find(".days_text").text(u),r.find(".hours_text").text(l),r.find(".minutes_text").text(c),r.find(".seconds_text").text(h)},1e3)}}(jQuery);