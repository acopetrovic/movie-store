function addActors(){
    $.confirm({
        title: 'Add Actor',
        content: ' <div class="title" style="text-align:center; color:white;padding:10px">' +
        '<form action="/Domain/actors/insert" method="post">'+
'<div class="form-group text-center">'+
'<label for="image text-center">Image URL<br></label>'+
'<input type="text" class="form-control" name="profilepictureurl" style="width: 40%;height: 34px;padding: 6px 12px;font-size: 14px;line-height: 1.42857143;color: #555;background-color: #fff;background-image: none;border: 1px solid #ccc;border-radius: 4px;"/>' +
'</div>'+
'<div class="form-group text-center">'+
'<label for="name">Name<br></label>'+
'<input type="text" class="form-control" name="fullname" style="color:white;width: 40%;height: 34px;padding: 6px 12px;font-size: 14px;line-height: 1.42857143;color: #555;background-color: #fff;background-image: none;border: 1px solid #ccc;border-radius: 4px;"/>' +
'</div>'+
'<div class="form-group text-center">'+
'<label for="bio">Biography<br></label>'+
'<input type="text" class="form-control" name="bio" style="color:white;width: 40%;height: 34px;padding: 6px 12px;font-size: 14px;line-height: 1.42857143;color: #555;background-color: #fff;background-image: none;border: 1px solid #ccc;border-radius: 4px;"/>'+
'</div>'+
'<button type="submit" class="btn btn-danger">Save update</button>'+
'</form>' +
'</div>' ,

        cancel: function(){

        }
    });
}

function addProducers(){
    $.confirm({
        title: 'Add Producer',
        content: ' <div class="title" style="text-align:center; color:white;padding:10px">' +
        '<form action="/Domain/producers/insert" method="post">'+
'<div class="form-group text-center">'+
'<label for="image text-center">Image URL<br></label>'+
'<input type="text" class="form-control" name="profilepictureurl" style="width: 40%;height: 34px;padding: 6px 12px;font-size: 14px;line-height: 1.42857143;color: #555;background-color: #fff;background-image: none;border: 1px solid #ccc;border-radius: 4px;"/>' +
'</div>'+
'<div class="form-group text-center">'+
'<label for="name">Name<br></label>'+
'<input type="text" class="form-control" name="fullname" style="width: 40%;height: 34px;padding: 6px 12px;font-size: 14px;line-height: 1.42857143;color: #555;background-color: #fff;background-image: none;border: 1px solid #ccc;border-radius: 4px;"/>' +
'</div>'+
'<div class="form-group text-center">'+
'<label for="bio">Biography<br></label>'+
'<input type="text" class="form-control" name="bio" style="width: 40%;height: 34px;padding: 6px 12px;font-size: 14px;line-height: 1.42857143;color: #555;background-color: #fff;background-image: none;border: 1px solid #ccc;border-radius: 4px;"/>'+
'</div>'+
'<button type="submit" class="btn btn-danger">Save update</button>'+
'</form>' +
'</div>' ,

        cancel: function(){

        }
    });
}

function addCinemas(){
    $.confirm({
        title: 'Add Cinema',
        content: ' <div class="title" style="text-align:center; color:white;padding:10px">' +
        '<form action="/Domain/cinemas/insert" method="post">'+
'<div class="form-group text-center">'+
'<label for="image text-center">Image URL<br></label>'+
'<input type="text" class="form-control" name="profilepictureurl" style="width: 40%;height: 34px;padding: 6px 12px;font-size: 14px;line-height: 1.42857143;color: #555;background-color: #fff;background-image: none;border: 1px solid #ccc;border-radius: 4px;"/>' +
'</div>'+
'<div class="form-group text-center">'+
'<label for="name">Name<br></label>'+
'<input type="text" class="form-control" name="fullname" style="width: 40%;height: 34px;padding: 6px 12px;font-size: 14px;line-height: 1.42857143;color: #555;background-color: #fff;background-image: none;border: 1px solid #ccc;border-radius: 4px;"/>' +
'</div>'+
'<div class="form-group text-center">'+
'<label for="bio">Biography<br></label>'+
'<input type="text" class="form-control" name="bio" style="width: 40%;height: 34px;padding: 6px 12px;font-size: 14px;line-height: 1.42857143;color: #555;background-color: #fff;background-image: none;border: 1px solid #ccc;border-radius: 4px;"/>'+
'</div>'+
'<button type="submit" class="btn btn-danger">Save update</button>'+
'</form>' +
'</div>' ,

        cancel: function(){

        }
    });
}