Prism.languages.treeview={"treeview-part":{pattern:/(^|\n).+/,inside:{"entry-line":[{pattern:/\|-- |├── /,alias:"line-h"},{pattern:/\|   |│   /,alias:"line-v"},{pattern:/`-- |└── /,alias:"line-v-last"},{pattern:/ {4}/,alias:"line-v-gap"}],"entry-name":{pattern:/.*\S.*/,inside:{operator:/ -> /}}}}},Prism.hooks.add("wrap",function(e){if("treeview"===e.language&&("treeview-part"===e.type&&(e.content=e.content.replace(/\n/g,"")+"<br />"),"entry-name"===e.type)){if(/(^|[^\\])\/\s*$/.test(e.content))e.content=e.content.slice(0,-1),e.classes.push("dir");else{/(^|[^\\])[=*|]\s*$/.test(e.content)&&(e.content=e.content.slice(0,-1));for(var t=e.content.toLowerCase().split(".");t.length>1;)t.shift(),e.classes.push("ext-"+t.join("-"))}"."===e.content.charAt(0)&&e.classes.push("dotfile")}});