FROM docker.io/library/rust:latest as rinha

RUN cargo install rinha

FROM gradle:latest
USER gradle

COPY var/rinha /var/rinha
COPY --from=rinha /usr/local/cargo/bin/ /usr/local/cargo/bin/

RUN echo "export PATH=$PATH:/usr/local/cargo/bin" > /home/gradle/.bashrc

CMD ["tail", "-f", "/dev/null"]
