package com.valladolid.jhon.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.valladolid.jhon.laboratoriocalificado02.databinding.ActivityDetallePedidoBinding
import com.valladolid.jhon.laboratoriocalificado02.databinding.ActivityEjercicio02Binding

class Ejercicio02 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)
        observeComponents()
    }

    private fun observeComponents() {
        binding.btnRegistrar.setOnClickListener {
            if (areInputsValid()) {
                navigateToDetallePedidoActivity()
            }
        }
    }

    private fun areInputsValid(): Boolean {
        if (binding.etNombreCliente.text.isEmpty()) {
            showToast("Por favor, ingresa el nombre del cliente.")
            return false
        }

        if (binding.etNumeroCliente.text.isEmpty()) {
            showToast("Por favor, ingresa el número de cliente.")
            return false
        } else if (binding.etNumeroCliente.text.length != 9) {
            showToast("El número de cliente debe tener 9 dígitos.")
            return false
        }

        if (binding.etProductos.text.isEmpty()) {
            showToast("Por favor, ingresa los productos.")
            return false
        }

        if (binding.etCiudad.text.isEmpty()) {
            showToast("Por favor, ingresa la ciudad.")
            return false
        }

        if (binding.etDireccion.text.isEmpty()) {
            showToast("Por favor, ingresa la dirección.")
            return false
        }

        return true
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun navigateToDetallePedidoActivity() {
        val intent = Intent(this, DetallePedido::class.java).apply {
            putExtra(FULL_NAME_KEY, binding.etNombreCliente.text.toString())
            putExtra(PHONE_NUMBER_KEY, binding.etNumeroCliente.text.toString())
            putExtra(PRODUCTO_KEY, binding.etProductos.text.toString())
            putExtra(CIUDAD_KEY, binding.etCiudad.text.toString())
            putExtra(DIRECCION_KEY, binding.etDireccion.text.toString())
        }
        startActivity(intent)
    }
}
