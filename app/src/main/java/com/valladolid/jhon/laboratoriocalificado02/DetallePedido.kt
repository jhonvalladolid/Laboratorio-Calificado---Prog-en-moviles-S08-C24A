package com.valladolid.jhon.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.valladolid.jhon.laboratoriocalificado02.databinding.ActivityDetallePedidoBinding

class DetallePedido : AppCompatActivity() {

    private lateinit var binding: ActivityDetallePedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallePedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDataFromIntent()

        binding.btnCall.setOnClickListener {
            val phoneNumber = binding.tvNumeroCliente.text.toString()
            makeCall(phoneNumber)
        }

        binding.btnWhatsApp.setOnClickListener {
            val phoneNumber = binding.tvNumeroCliente.text.toString()
            openWhatsAppChat(phoneNumber)
        }

        binding.btnMaps.setOnClickListener {
            val location = binding.tvUbicacion.text.toString()
            openMaps(location)
        }
    }

    private fun showDataFromIntent() {
        intent.extras?.let { extras ->
            binding.tvCliente.text = extras.getString(FULL_NAME_KEY)
            binding.tvNumeroCliente.text = extras.getString(PHONE_NUMBER_KEY)
            binding.tvProductos.text = extras.getString(PRODUCTO_KEY)

            val ciudad = extras.getString(CIUDAD_KEY)
            val direccion = extras.getString(DIRECCION_KEY)
            val ubicacion = "$ciudad, $direccion"
            binding.tvUbicacion.text = ubicacion

            // Puedes continuar asignando los valores a otras vistas según sea necesario
        }
    }


    private fun makeCall(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        startActivity(intent)
    }

    private fun openWhatsAppChat(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")
        }
        startActivity(intent)
    }

    private fun openMaps(location: String) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("geo:0,0?q=$location")
        }
        startActivity(intent)
    }
}
