const seachForm=document.getElementById("seachForm");
function validateForm() {
        var search = document.getElementById("search").value;

        if (/^[a-zA-Z0-9- ]*$/.test(search) == false) {
            alert("Designation should not contain special characters.");
            return false;
        }

        return true;
    }
 
 
seachForm.addEventListener("submit",(e)=>{
	
	if(!validateForm()){
		e.preventDefault()
	}
	
})  