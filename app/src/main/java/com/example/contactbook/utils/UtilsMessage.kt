package com.example.contactbook.utils

import android.content.Context
import com.google.android.material.dialog.MaterialAlertDialogBuilder

object UtilsMessage {
    fun showAlertOk(titulo: String?, mensaje: String?, contexto: Context) {
        val builder = MaterialAlertDialogBuilder(contexto)
        builder.setMessage(mensaje)
            .setTitle(titulo)
            .setCancelable(false)
            .setPositiveButton("Aceptar") { dialog, _ -> dialog.cancel() }
        builder.create().show()
    }
}