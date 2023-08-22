/**
 * 
 */
//modal edit
const editModal = document.getElementById('editModal')
if (editModal) {
	editModal.addEventListener('show.bs.modal', event => {
		// Button that triggered the modal
		const button = event.relatedTarget
		// Extract info from data-bs-* attributes
		const id = button.getAttribute('data-bs-id')
		const articulo = button.getAttribute('data-bs-art')
		const marca = button.getAttribute('data-bs-trad')
		const precio = button.getAttribute('data-bs-pri')
		const cantidad = button.getAttribute('data-bs-amo')

		const producto = [id, articulo, marca, precio, cantidad];
		// If necessary, you could initiate an Ajax request here
		// and then do the updating in a callback.

		// Update the modal's content.

		const modalTitle = editModal.querySelector('.modal-title')
		const modalBodyInput = editModal.querySelectorAll('.modal-body input')
		modalTitle.style.cssText = 'color: #004d40; font-weight: bold';
		//modalTitle.textContent = `New message to ${recipient}`
		//modalBodyInput.value = recipient
		for (let i = 0; i < modalBodyInput.length; i++) {
			modalBodyInput[i].value = producto[i]
		}
		
	})
}
//validation form - add product
const idForm = document.getElementById("idForm");
const idArticle = document.getElementById("idArticle");
const idTrademark = document.getElementById("idTrademark");
const idPrice = document.getElementById("idPrice");
const idAmount = document.getElementById("idAmount");
const info = document.getElementById("info-alert");
const imgAlert = document.getElementById("img-alert");

function validationForm() {
	const modalTitle = modalAlert.querySelector('.modal-title');
	modalTitle.style.cssText = 'color: #004d40; font-weight: bold; font-size: 2em';
	if (idArticle.value == "" || idTrademark.value == "" || idPrice.value == "" || idAmount.value == "") {
		info.textContent = "¡Hey! ¡Hay campos vacios!";
		return false;
	} else {
		if (!(Number(idPrice.value) && Number(idAmount.value))) {
			info.textContent = "Por favor, el precio y cantidad deben ser numeros. Vuelve intentarlo.";
			return false;
		} else {
			imgAlert.innerHTML = '<img src="./img/check.png" class="img-fluid w-25"; >'
			info.textContent = "¡Registro exitoso!";
			return true;
		}
	}
}

//validation editModal
const idFormEdit = document.getElementById("editModal");
const idArticleEdit = document.getElementById("art-m");
const idTrademarkEdit = document.getElementById("trad-m");
const idPriceEdit = document.getElementById("pri-m");
const idAmountEdit = document.getElementById("amo-m");
const infoEdit = document.getElementById("info-alert");

function validationFormEdit() {
	const modalTitle = modalAlert.querySelector('.modal-title');
	modalTitle.textContent = "Modificación cancelada";
	modalTitle.style.cssText = 'color: red; font-weight: bold; font-size: 2em';
	if (idArticleEdit.value == "" || idTrademarkEdit.value == "" || idPriceEdit.value == "" || idAmountEdit.value == "") {
		infoEdit.textContent = " ¡Hay campos vacios! Vuelve a intentarlo.";
		return false;
	} else {
		if (!(Number(idPriceEdit.value) && Number(idAmountEdit.value))) {
			infoEdit.textContent = "Por favor, el precio y cantidad deben ser numeros. Vuelve intentarlo.";
			return false;
		} else {
		
			modalTitle.style.cssText = 'color: #004d40; font-weight: bold; font-size: 2em';
			modalTitle.textContent = "¡Se han guardado los cambios!";
			//infoEdit.textContent = "¡Modificado con exito!";
			imgAlert.innerHTML = '<img src="./img/check.png" class="img-fluid w-25"; >'
			return true;
		}
	}
}

//modal delete
const modalDelete = document.getElementById('modalDelete')
if (modalDelete) {
	modalDelete.addEventListener('show.bs.modal', event => {
		// Button that triggered the modal
		const button = event.relatedTarget
		// Extract info from data-bs-* attributes
		const id = button.getAttribute('data-bs-id')
		const articulo = button.getAttribute('data-bs-art')
		const marca = button.getAttribute('data-bs-trad')
		const precio = button.getAttribute('data-bs-pri')
		

		const producto = `¿Desea eliminar ${articulo} de la marca ${marca} con precio ${precio}`
		// If necessary, you could initiate an Ajax request here
		// and then do the updating in a callback.

		// Update the modal's content.
		const textDelete = modalDelete.querySelector("#h6-delete");
		const modalTitle = modalDelete.querySelector('.modal-title')
		const modalBodyInput = modalDelete.querySelector('.modal-body input')
		modalTitle.style.cssText = 'color: #004d40; font-weight: bold';
		//modalTitle.textContent = `New message to ${recipient}`
		//modalBodyInput.value = recipient
		modalBodyInput.value = id;
		textDelete.textContent = producto;
		
	})
}

