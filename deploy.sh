#!/bin/bash

echo "======================================"
echo "  Compilando aplicação..."
echo "======================================"

# Compila o projeto
mvn clean package

# Verifica se a compilação foi bem-sucedida
if [ $? -ne 0 ]; then
    echo "Erro na compilação!"
    exit 1
fi

echo ""
echo "======================================"
echo "  Copiando JAR para ~/doc/bin..."
echo "======================================"

# Cria o diretório de destino se não existir
mkdir -p ~/doc/bin

# Remove JARs antigos
rm -f ~/doc/bin/*.jar

# Copia o JAR gerado
cp target/*.jar ~/doc/bin/doc.jar

# Verifica se a cópia foi bem-sucedida
if [ $? -eq 0 ]; then
    echo ""
    echo "======================================"
    echo "  Deploy concluído com sucesso!"
    echo "======================================"
    echo "JAR copiado para: ~/doc/bin/"
    ls -lh ~/doc/bin/*.jar
else
    echo "Erro ao copiar o JAR!"
    exit 1
fi
