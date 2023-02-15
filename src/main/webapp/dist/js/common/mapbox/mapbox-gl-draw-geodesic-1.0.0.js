!function(t,e){"object"==typeof exports&&"undefined"!=typeof module?e(exports,require("@mapbox/mapbox-gl-draw")):"function"==typeof define&&define.amd?define(["exports","@mapbox/mapbox-gl-draw"],e):e((t=t||self).MapboxDrawGeodesic={},t.MapboxDraw)}(this,(function(t,e){"use strict";e=e&&Object.prototype.hasOwnProperty.call(e,"default")?e.default:e;const r="add",o="none",n="Feature",i="Polygon",s="LineString",a="Point",c="Multi",u="MultiLineString",p="draw_line_string",h="draw_polygon",l="draw_point",f="simple_select",d="direct_select",y="static",g="draw.create",b="midpoint",m="vertex",O="true",w="false",M="circleRadius";var v=function(t,e,r){return e in t?Object.defineProperty(t,e,{value:r,enumerable:!0,configurable:!0,writable:!0}):t[e]=r,t};function j(t,e,r){return t(r={path:e,exports:{},require:function(t,e){return function(){throw new Error("Dynamic requires are not currently supported by @rollup/plugin-commonjs")}(null==e&&r.path)}},r.exports),r.exports}var P=j((function(t){var e=t.exports=function(t,r){if(r||(r=16),void 0===t&&(t=128),t<=0)return"0";for(var o=Math.log(Math.pow(2,t))/Math.log(r),n=2;o===1/0;n*=2)o=Math.log(Math.pow(2,t/n))/Math.log(r)*n;var i=o-Math.floor(o),s="";for(n=0;n<Math.floor(o);n++){s=Math.floor(Math.random()*r).toString(r)+s}if(i){var a=Math.pow(r,i);s=Math.floor(Math.random()*a).toString(r)+s}var c=parseInt(s,r);return c!==1/0&&c>=Math.pow(2,t)?e(t,r):s};e.rack=function(t,r,o){var n=function(n){var s=0;do{if(s++>10){if(!o)throw new Error("too many ID collisions, use more bits");t+=o}var a=e(t,r)}while(Object.hasOwnProperty.call(i,a));return i[a]=n,a},i=n.hats={};return n.get=function(t){return n.hats[t]},n.set=function(t,e){return n.hats[t]=e,n},n.bits=t||128,n.base=r||16,n}}));function x(t,e){var r=Object.keys(t);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(t);e&&(o=o.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),r.push.apply(r,o)}return r}function E(t){for(var e=1;e<arguments.length;e++){var r=null!=arguments[e]?arguments[e]:{};e%2?x(Object(r),!0).forEach((function(e){v(t,e,r[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(r)):x(Object(r)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(r,e))}))}return t}function D(t,e,r={}){if(!(e>0))throw new Error("Radius has to be greater then 0");return{id:P(),type:n,properties:E({[M]:e},r),geometry:{type:i,coordinates:[[t,t,t,t,t]]}}}function S(t){return t.geometry.type===i&&"number"==typeof t.properties[M]&&t.properties[M]>0}function R(t){if(!S(t))throw new Error("GeoJSON is not a circle");return t.geometry.coordinates[0][0]}function I(t){if(!S(t))throw new Error("GeoJSON is not a circle");return t.properties[M]}var C=j((function(t){var e=Math.PI/180,r=180/Math.PI,o=function(t,r){this.lon=t,this.lat=r,this.x=e*t,this.y=e*r};o.prototype.view=function(){return String(this.lon).slice(0,4)+","+String(this.lat).slice(0,4)},o.prototype.antipode=function(){var t=-1*this.lat,e=this.lon<0?180+this.lon:-1*(180-this.lon);return new o(e,t)};var n=function(){this.coords=[],this.length=0};n.prototype.move_to=function(t){this.length++,this.coords.push(t)};var i=function(t){this.properties=t||{},this.geometries=[]};i.prototype.json=function(){if(this.geometries.length<=0)return{geometry:{type:"LineString",coordinates:null},type:"Feature",properties:this.properties};if(1==this.geometries.length)return{geometry:{type:"LineString",coordinates:this.geometries[0].coords},type:"Feature",properties:this.properties};for(var t=[],e=0;e<this.geometries.length;e++)t.push(this.geometries[e].coords);return{geometry:{type:"MultiLineString",coordinates:t},type:"Feature",properties:this.properties}},i.prototype.wkt=function(){for(var t="",e="LINESTRING(",r=function(t){e+=t[0]+" "+t[1]+","},o=0;o<this.geometries.length;o++){if(0===this.geometries[o].coords.length)return"LINESTRING(empty)";this.geometries[o].coords.forEach(r),t+=e.substring(0,e.length-1)+")"}return t};var s=function(t,e,r){if(!t||void 0===t.x||void 0===t.y)throw new Error("GreatCircle constructor expects two args: start and end objects with x and y properties");if(!e||void 0===e.x||void 0===e.y)throw new Error("GreatCircle constructor expects two args: start and end objects with x and y properties");this.start=new o(t.x,t.y),this.end=new o(e.x,e.y),this.properties=r||{};var n=this.start.x-this.end.x,i=this.start.y-this.end.y,s=Math.pow(Math.sin(i/2),2)+Math.cos(this.start.y)*Math.cos(this.end.y)*Math.pow(Math.sin(n/2),2);if(this.g=2*Math.asin(Math.sqrt(s)),this.g==Math.PI)throw new Error("it appears "+t.view()+" and "+e.view()+" are 'antipodal', e.g diametrically opposite, thus there is no single route but rather infinite");if(isNaN(this.g))throw new Error("could not calculate great circle between "+t+" and "+e)};s.prototype.interpolate=function(t){var e=Math.sin((1-t)*this.g)/Math.sin(this.g),o=Math.sin(t*this.g)/Math.sin(this.g),n=e*Math.cos(this.start.y)*Math.cos(this.start.x)+o*Math.cos(this.end.y)*Math.cos(this.end.x),i=e*Math.cos(this.start.y)*Math.sin(this.start.x)+o*Math.cos(this.end.y)*Math.sin(this.end.x),s=e*Math.sin(this.start.y)+o*Math.sin(this.end.y),a=r*Math.atan2(s,Math.sqrt(Math.pow(n,2)+Math.pow(i,2)));return[r*Math.atan2(i,n),a]},s.prototype.Arc=function(t,e){var r=[];if(!t||t<=2)r.push([this.start.lon,this.start.lat]),r.push([this.end.lon,this.end.lat]);else for(var o=1/(t-1),s=0;s<t;++s){var a=o*s,c=this.interpolate(a);r.push(c)}for(var u=!1,p=0,h=e&&e.offset?e.offset:10,l=180-h,f=-180+h,d=360-h,y=1;y<r.length;++y){var g=r[y-1][0],b=r[y][0],m=Math.abs(b-g);m>d&&(b>l&&g<f||g>l&&b<f)?u=!0:m>p&&(p=m)}var O=[];if(u&&p<h){var w=[];O.push(w);for(var M=0;M<r.length;++M){var v=parseFloat(r[M][0]);if(M>0&&Math.abs(v-r[M-1][0])>d){var j=parseFloat(r[M-1][0]),P=parseFloat(r[M-1][1]),x=parseFloat(r[M][0]),E=parseFloat(r[M][1]);if(j>-180&&j<f&&180==x&&M+1<r.length&&r[M-1][0]>-180&&r[M-1][0]<f){w.push([-180,r[M][1]]),M++,w.push([r[M][0],r[M][1]]);continue}if(j>l&&j<180&&-180==x&&M+1<r.length&&r[M-1][0]>l&&r[M-1][0]<180){w.push([180,r[M][1]]),M++,w.push([r[M][0],r[M][1]]);continue}if(j<f&&x>l){var D=j;j=x,x=D;var S=P;P=E,E=S}if(j>l&&x<f&&(x+=360),j<=180&&x>=180&&j<x){var R=(180-j)/(x-j),I=R*E+(1-R)*P;w.push([r[M-1][0]>l?180:-180,I]),(w=[]).push([r[M-1][0]>l?-180:180,I]),O.push(w)}else w=[],O.push(w);w.push([v,r[M][1]])}else w.push([r[M][0],r[M][1]])}}else{var C=[];O.push(C);for(var _=0;_<r.length;++_)C.push([r[_][0],r[_][1]])}for(var F=new i(this.properties),N=0;N<O.length;++N){var L=new n;F.geometries.push(L);for(var k=O[N],G=0;G<k.length;++G)L.move_to(k[G])}return F},t.exports.Coord=o,t.exports.Arc=i,t.exports.GreatCircle=s}));function _(t,e){return t[0]===e[0]&&t[1]===e[1]}function F(t,e=32){var r;const o=(r=t).slice(0,-1).map((t,e)=>[t,r[e+1]]).filter(t=>!_(t[0],t[1])).map(t=>new C.GreatCircle({x:t[0][0],y:t[0][1]},{x:t[1][0],y:t[1][1]}).Arc(e,{offset:90}).json());let n=!1;const i=o.map(t=>{if(t.geometry.type===u){n=!n;const e=t.geometry.coordinates[0][0][0]>t.geometry.coordinates[1][0][0];return[...t.geometry.coordinates[0].map(t=>[t[0]+(e?0:360),t[1]]),...t.geometry.coordinates[1].map(t=>[t[0]+(e?360:0),t[1]])]}return t.geometry.coordinates.map(t=>[t[0]+(n?360:0),t[1]])}).flat();return i.filter((t,e)=>e===i.length-1||!_(t,i[e+1]))}function N(t){return t/180*Math.PI}function L(t){return t/Math.PI*180}function k(t){return t*Math.PI/180}function G(t){return 180*t/Math.PI}function T(t,e,r){var o=k(t[1]),n=k(t[0]),i=e/6378137,s=Math.asin(Math.sin(o)*Math.cos(i)+Math.cos(o)*Math.sin(i)*Math.cos(r));return[G(n+Math.atan2(Math.sin(r)*Math.sin(i)*Math.cos(o),Math.cos(i)-Math.sin(o)*Math.sin(s))),G(s)]}function J({center:t,radius:e,numberOfSegments:r}){!function(t){if(!Array.isArray(t)||![2,3].includes(t.length))throw new Error("ERROR! Center has to be an array of length two or three");const[e,r]=t;if("number"!=typeof e||"number"!=typeof r)throw new Error("ERROR! Longitude and Latitude has to be numbers but where ".concat(typeof e," and ").concat(typeof r));if(e>180||e<-180)throw new Error("ERROR! Longitude has to be between -180 and 180 but was ".concat(e));if(r>90||r<-90)throw new Error("ERROR! Latitude has to be between -90 and 90 but was ".concat(r))}(t),function(t){if("number"!=typeof t)throw new Error("ERROR! Radius has to be a positive number but was: ".concat(typeof t));if(t<=0)throw new Error("ERROR! Radius has to be a positive number but was: ".concat(t))}(e),function(t){if("number"!=typeof t&&void 0!==t)throw new Error("ERROR! Number of segments has to be a number but was: ".concat(typeof t));if(t<3)throw new Error("ERROR! Number of segments has to be at least 3 but was: ".concat(t))}(r)}function A(t,e,r){const o=[((t[0]+180)%360+360)%360-180,t[1]],n=function(t,e,r){var o=r||32;J({center:t,radius:e,numberOfSegments:r});for(var n=[],i=0;i<o;++i)n.push(T(t,e,2*Math.PI*-i/o));return n.push(n[0]),{type:"Polygon",coordinates:[n]}}(o,1e3*e,r);return n.coordinates[0].map(e=>[e[0]+(t[0]-o[0]),e[1]])}function q(t,e){var r=Object.keys(t);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(t);e&&(o=o.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),r.push.apply(r,o)}return r}function V(t){for(var e=1;e<arguments.length;e++){var r=null!=arguments[e]?arguments[e]:{};e%2?q(Object(r),!0).forEach((function(e){v(t,e,r[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(r)):q(Object(r)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(r,e))}))}return t}function Z(t,e){const r=Math.min(...t.map(e));return t.find(t=>e(t)===r)}function U(t,e){const r=Math.max(...t.map(e));return t.find(t=>e(t)===r)}function K(t,e){const r=e.split(".").map(t=>parseInt(t,10)).reduce((t,e)=>t[e],t);return JSON.parse(JSON.stringify(r))}function H(t,e){e=V({steps:32},e);const r=t.properties,o=t.geometry.type,u=t.geometry.coordinates,p=r.parent||r.id,h=e.ctx.store.get(p).toGeoJSON();if(o===a)return(r.meta===m||r.meta===b)&&h&&S(h)?[]:r.meta===b?function(){const e=r.coord_path,o=e.split(".").map(t=>parseInt(t,10)),n=o.map((t,e)=>t+(e===o.length-1?-1:0)).join("."),i=e,s=K(h.geometry.coordinates,n),a=K(h.geometry.coordinates,i),c=function(t,e){const r=N(e[0]-t[0]),o=N(t[1]),n=N(e[1]),i=N(t[0]),s=Math.cos(n)*Math.cos(r),a=Math.cos(n)*Math.sin(r),c=Math.atan2(Math.sin(o)+Math.sin(n),Math.sqrt((Math.cos(o)+s)*(Math.cos(o)+s)+a*a));return[L(i+Math.atan2(a,Math.cos(o)+s)),L(c)]}(s,a);return[V(V({},t),{},{properties:V(V({},r),{},{lng:c[0],lat:c[1]}),geometry:V(V({},t.geometry),{},{coordinates:c})})]}():[t];if(o===s)return function(){const r=F(u,e.steps);return[V(V({},t),{},{geometry:V(V({},t.geometry),{},{coordinates:r})})]}();if(o===i)return h&&S(h)?function(){const o=R(h),i=I(h),s=A(o,i,4*e.steps),c=V(V({},t),{},{geometry:V(V({},t.geometry),{},{coordinates:[s]})});if(r.active===O){const t=[U(s,t=>t[0]),Z(s,t=>t[0]),U(s,t=>t[1]),Z(s,t=>t[1])].map((t,o)=>function(t,e,r,o){return{type:n,properties:{meta:m,parent:t,coord_path:r,active:o?O:w},geometry:{type:a,coordinates:e}}}(r.id,t,"0.".concat(o),function(t){if(!e.selectedPaths)return!1;return-1!==e.selectedPaths.indexOf(t)}("0.".concat(o))));return[c,...t]}return[c]}():function(){const e=u.map(t=>F(t));return[V(V({},t),{},{geometry:V(V({},t.geometry),{},{coordinates:e})})]}();if(0===o.indexOf(c))return function(){const i=o.replace(c,""),s=u.map(t=>H({type:n,properties:r,geometry:{type:i,coordinates:t}},e)).flat().map(t=>t.geometry.coordinates);return[V(V({},t),{},{geometry:V(V({},t.geometry),{},{coordinates:s})})]}()}function B(t,e){var r=Object.keys(t);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(t);e&&(o=o.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),r.push.apply(r,o)}return r}const z=e.modes[p],Q=function(t){for(var e=1;e<arguments.length;e++){var r=null!=arguments[e]?arguments[e]:{};e%2?B(Object(r),!0).forEach((function(e){v(t,e,r[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(r)):B(Object(r)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(r,e))}))}return t}({},z);function W(t,e){var r=Object.keys(t);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(t);e&&(o=o.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),r.push.apply(r,o)}return r}Q.toDisplayFeatures=function(t,e,r){z.toDisplayFeatures.call(this,t,e,t=>{H(t,{ctx:this._ctx}).forEach(r)})};const X=e.modes[h],Y=function(t){for(var e=1;e<arguments.length;e++){var r=null!=arguments[e]?arguments[e]:{};e%2?W(Object(r),!0).forEach((function(e){v(t,e,r[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(r)):W(Object(r)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(r,e))}))}return t}({},X);Y.toDisplayFeatures=function(t,e,r){X.toDisplayFeatures.call(this,t,e,t=>{H(t,{ctx:this._ctx}).forEach(r)})};var $={enable(t){setTimeout(()=>{t.map&&t.map.doubleClickZoom&&t._ctx&&t._ctx.store&&t._ctx.store.getInitialConfigValue&&t._ctx.store.getInitialConfigValue("doubleClickZoom")&&t.map.doubleClickZoom.enable()},0)},disable(t){setTimeout(()=>{t.map&&t.map.doubleClickZoom&&t.map.doubleClickZoom.disable()},0)}},tt=rt;const et={MILE:3959,KM:6371,M:6371e3,NMI:3440};function rt(t,e,r){r=function(t){return(t=t||{}).radius=t.radius||et.MILE,t.isRadians="boolean"==typeof t.isRadians&&t.isRadians,t}(r);const o=ot(t.latitude,r.isRadians),n=ot(e.latitude,r.isRadians),i=(s=t.longitude,a=e.longitude,c=r.isRadians,ot(a-s,c));var s,a,c;const u=Math.acos(Math.sin(o)*Math.sin(n)+Math.cos(o)*Math.cos(n)*Math.cos(i));return r.radius*u}function ot(t,e){return e?t:t*(Math.PI/180)}function nt(t,e){return tt({latitude:t[1],longitude:t[0]},{latitude:e[1],longitude:e[0]},{radius:tt.EARTH.KM})}rt.EARTH=et;const it={enable(t){setTimeout(()=>{t.map&&t.map.dragPan&&t._ctx&&t._ctx.store&&t._ctx.store.getInitialConfigValue&&t._ctx.store.getInitialConfigValue("dragPan")&&t.map.dragPan.enable()},0)},disable(t){setTimeout(()=>{t.map&&t.map.doubleClickZoom&&t.map.dragPan.disable()},0)}},st={};function at(t,e){var r=Object.keys(t);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(t);e&&(o=o.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),r.push.apply(r,o)}return r}st.onSetup=function(t){return this.clearSelectedFeatures(),$.disable(this),it.disable(this),this.updateUIClasses({mouse:r}),this.setActionableState(),{}},st.onMouseDown=st.onTouchStart=function(t,e){const r=[e.lngLat.lng,e.lngLat.lat],o=this.newFeature(D(r,Number.EPSILON));this.addFeature(o),t.circle=o},st.onDrag=st.onTouchMove=function(t,e){const r=[e.lngLat.lng,e.lngLat.lat];if(t.circle){const e=nt(R(t.circle.toGeoJSON()),r);t.circle.setProperty(M,e),t.circle.changed()}},st.onMouseUp=st.onTouchEnd=function(t,e){return this.map.fire(g,{features:[t.circle.toGeoJSON()]}),this.changeMode(f,{featureIds:[t.circle.id]})},st.onKeyUp=function(t,e){!function(t){return 27===t.keyCode}(e)?function(t){return 13===t.keyCode}(e)&&this.changeMode(f,{featureIds:[t.circle.id]}):(t.circle&&this.deleteFeature([t.circle.id],{silent:!0}),this.changeMode(f))},st.onStop=function(){this.updateUIClasses({mouse:o}),$.enable(this),it.enable(this),this.activateUIButton()},st.toDisplayFeatures=function(t,e,r){if(t.circle){const r=e.properties.id===t.circle.id;e.properties.active=r?O:w}(t=>{H(t,{ctx:this._ctx}).forEach(r)})(e)};const ct=e.modes[l],ut=function(t){for(var e=1;e<arguments.length;e++){var r=null!=arguments[e]?arguments[e]:{};e%2?at(Object(r),!0).forEach((function(e){v(t,e,r[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(r)):at(Object(r)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(r,e))}))}return t}({},ct);function pt(t,e){var r=Object.keys(t);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(t);e&&(o=o.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),r.push.apply(r,o)}return r}ut.toDisplayFeatures=function(t,e,r){ct.toDisplayFeatures.call(this,t,e,t=>{H(t,{ctx:this._ctx}).forEach(r)})};const ht=e.modes[f],lt=function(t){for(var e=1;e<arguments.length;e++){var r=null!=arguments[e]?arguments[e]:{};e%2?pt(Object(r),!0).forEach((function(e){v(t,e,r[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(r)):pt(Object(r)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(r,e))}))}return t}({},ht);function ft(t,e){var r=Object.keys(t);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(t);e&&(o=o.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),r.push.apply(r,o)}return r}lt.toDisplayFeatures=function(t,e,r){ht.toDisplayFeatures.call(this,t,e,t=>{H(t,{ctx:this._ctx}).forEach(r)})};const dt=e.modes[d],yt=function(t){for(var e=1;e<arguments.length;e++){var r=null!=arguments[e]?arguments[e]:{};e%2?ft(Object(r),!0).forEach((function(e){v(t,e,r[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(r)):ft(Object(r)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(r,e))}))}return t}({},dt);yt.dragVertex=function(t,e,r){const o=[e.lngLat.lng,e.lngLat.lat],n=t.feature.toGeoJSON();if(S(n)){const e=nt(R(n),o);t.feature.setProperty(M,e),t.feature.changed()}else dt.dragVertex.call(this,t,e,r)},yt.toDisplayFeatures=function(t,e,r){dt.toDisplayFeatures.call(this,t,e,e=>{H(e,{ctx:this._ctx,selectedPaths:t.selectedCoordPaths}).forEach(r)})};const gt={onSetup:function(){return this.setActionableState(),{}},toDisplayFeatures:function(t,e,r){(t=>{H(t,{ctx:this._ctx}).forEach(r)})(e)}},bt={[p]:Q,[h]:Y,draw_circle:st,[l]:ut,[f]:lt,[d]:yt,[y]:gt};t.createCircle=D,t.getCircleCenter=R,t.getCircleRadius=I,t.isCircle=S,t.modes=bt,t.setCircleCenter=function(t,e){if(!S(t))throw new Error("GeoJSON is not a circle");t.geometry.coordinates=[[e,e,e,e,e]]},t.setCircleRadius=function(t,e){if(!S(t))throw new Error("GeoJSON is not a circle");t.properties[M]=e},Object.defineProperty(t,"__esModule",{value:!0})}));
//# sourceMappingURL=mapbox-gl-draw-geodesic.min.js.map