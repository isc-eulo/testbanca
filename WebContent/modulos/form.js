/**
 * 
 *//* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


require([
  "dojo/_base/declare",
    "dijit/_WidgetBase",
    "dijit/_OnDijitClickMixin",
    "dijit/_TemplatedMixin",
    "dijit/_WidgetsInTemplateMixin",
    "dojo/text!./modulos/form.html",
    
    "dijit/form/Form",
    "dojox/layout/TableContainer", 
    "dijit/form/TextBox", 
    "dijit/form/ValidationTextBox"
],
  function(declare, _OnDijitClickMixin, _WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, template) {
    return declare([_WidgetBase, _OnDijitClickMixin, _TemplatedMixin, _WidgetsInTemplateMixin], {
            templateString:template,
    
        });
    }
        
        );
