package com.example.compotent.ui.components

import android.widget.Button
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filleds.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.compotent.model.Produto
import java.lang.reflect.Modifier

@Composable
fun ProdutoCard(
    produto: Produto,
    onComprar : () -> Unit
) {
    var animar by remember {
        mutableStateOf(false)
    }

    val largura by animateDpAsState(
        targetValue = if(animar) 180.dp else 130.dp,
        label= ""
    )

    Card{
        Colunm(
            modifier.padding(16.dp)
        ){
            Text(produto.nome)
            Text("R$ %.2f".format(produto.preco))
            Spacer(modifier = Modifier.height(10.dp))

            Button(
                modifier = Modifier.width(largura),
                  onClick = {
                      animar = !animar
                      onComprar()
                  }
            ){
                Icon(
                    Icons.Default.ShoppingCart,
                    contentDescription = null
                )
                Spacer(Modifier.width(8.dp))
                Text("Comprar")
            }
        }
    }
}
