function addActors(){
    $.confirm({
        title: 'Add Actor',
        content: '<form action="/Domain/actors/{{actors.id}}/update" method="post">'+
'<div class="form-group text-center">'+
'<label for="image text-center">Image URL</label>'+
'<input type="text" class="form-control" name="profilepictureurl" style="width:40%;margin-left:auto;margin-right:auto;"/>' +
'</div>'+
'<div class="form-group text-center">'+
'<label for="name">Name</label>'+
'<input type="text" class="form-control" name="fullname" style="width:40%;margin-left:auto;margin-right:auto;"/>' +
'</div>'+
'<div class="form-group text-center">'+
'<label for="bio">Biography</label>'+
'<input type="text" class="form-control" name="bio" style="width:40%;margin-left:auto;margin-right:auto;"/>'+
'</div>'+
'<button type="submit" class="btn btn-danger" style="float:right;margin-right:30%;">Save update</button>'+
'</form>',

        cancel: function(){

        }
    });
}