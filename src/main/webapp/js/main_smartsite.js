
$(function () {

    function getMenuHtml(nodeList,jueryObj){
        var html="";
        var len=nodeList.length;
        for(var a=0;a<len;a++){
            var rankId=nodeList[a].rankId;
           // alert(nodeList[a].name);
            switch(rankId){//根据菜单的层级，来显示不同的样式
                case 1:
                    html='<li id="id'+nodeList[a].id+'" link='+nodeList[a].htmlName+' hasChild='+nodeList[a].hasChild+'><a href="#" class="dropdown-toggle">'
                        +'<i class="menu-icon fa fa-desktop"></i><span class="menu-text">'
                        +nodeList[a].name+'</span><b class="arrow fa fa-angle-down"></b></a><b class="arrow"></b></li>';
                    jueryObj.append(html);
                    break;
                case 2:
                    html='<li id="id'+nodeList[a].id+'" link='+nodeList[a].htmlName+' hasChild='+nodeList[a].hasChild+'><a href="#" class="dropdown-toggle"><i class="menu-icon fa fa-caret-right"></i>'
                        +nodeList[a].name+'<b class="arrow"></b></a></li>';
                    jueryObj.append(html);
                    break;
                case 3:
                    html='<li id="id'+nodeList[a].id+'" link='+nodeList[a].htmlName+' hasChild='+nodeList[a].hasChild+'><a href="#"><i class="menu-icon fa fa-caret-right"></i>'
                        +nodeList[a].name+'<b class="arrow"></b></a></li>';
                    jueryObj.append(html);
                    break;


            }
            if(nodeList[a].childes.length>=1){
                $("#id"+nodeList[a].id).append('<ul class="submenu"></ul>');
                getMenuHtml(nodeList[a].childes,$("#id"+nodeList[a].id).find("ul"));

            }

        }

    }

    getAjaxData("api/main/getAllMenuNode.do","",function (data) {
          var node=data.resultData;
     getMenuHtml(node,$("#menu"));


    });

/*    $.ajax({
        url:'api/main/getAllMenuNode.do',
        type:'GET',
        dataType:'json',
        success:function (data) {
            alert(JSON.stringify(data));
        }
    })*/

    //迭代<li>菜单，设定没有子菜单的菜单的点击跳转页面
        $("li").each(function () {
              if($(this).attr('hasChild')==0){
                 $(this).click(function () {
                     var htmlName=$(this).attr('link');
                     $(".page-content-area").load("html/"+htmlName+"_html/"+htmlName+".html");
                 });
              }
        })

});